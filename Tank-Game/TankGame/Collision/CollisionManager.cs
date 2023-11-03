using Microsoft.Xna.Framework;
using System;
using System.Collections.Generic;
using TankGame.Model;

namespace TankGame.Collision
{
    public class CollisionManager : IMovementResolver
    {
        public List<ICollideable> collideables;

        public CollisionManager()
        {
            this.collideables = new List<ICollideable>();
        }

        public void Add(ICollideable collideable)
        {
            collideables.Add(collideable);
        }

        public void Remove(ICollideable collideable)
        {
            collideables.Remove(collideable);
        }

        public void ResolveAttemptedMove(Position position)
        {
            Polygon a = BuildPolygon(position);
            Vector2 offset = new Vector2(0, 0);
            bool intersect = false;
            foreach (ICollideable collideable in collideables)
            {
                if (collideable.Position == position)
                {
                    continue;
                }

                Polygon collider = BuildPolygon(collideable.Position);

                PolygonCollisionResult result = PolygonCollision(a, collider, position.GetDirection() - collideable.Position.GetDirection());


                if (result.WillIntersect)
                {
                    intersect = true;
                    offset += result.MinimumTranslationVector;
                }
            }

            position.UpdateRotation();
            if (intersect)
            {
                position.UpdatePosition(offset);
            }
            else
            {
                position.UpdatePosition();
            }
        }

        private Polygon BuildPolygon(Position position)
        {
            Polygon poly = new Polygon();
            poly.Points = new Vector2[4];
            poly.Edges = new Vector2[4];

            poly.Points[0] = CalculateRotatedPoint(new Vector2(position.X - position.W /2, position.Y - position.H / 2), position.GetPosition(), position.GetRotation());
            poly.Points[1] = CalculateRotatedPoint(new Vector2(position.X - position.W /2, position.Y + position.H / 2), position.GetPosition(), position.GetRotation());
            poly.Points[2] = CalculateRotatedPoint(new Vector2(position.X + position.W /2, position.Y + position.H / 2), position.GetPosition(), position.GetRotation());
            poly.Points[3] = CalculateRotatedPoint(new Vector2(position.X + position.W /2, position.Y - position.H / 2), position.GetPosition(), position.GetRotation());

            poly.Edges[1] = new Vector2(poly.Points[1].X - poly.Points[0].X, poly.Points[1].Y - poly.Points[0].Y);
            poly.Edges[2] = new Vector2(poly.Points[2].X - poly.Points[1].X, poly.Points[2].Y - poly.Points[1].Y);
            poly.Edges[3] = new Vector2(poly.Points[3].X - poly.Points[2].X, poly.Points[3].Y - poly.Points[2].Y);
            poly.Edges[0] = new Vector2(poly.Points[0].X - poly.Points[3].X, poly.Points[0].Y - poly.Points[3].Y);

            return poly;
        }

        private Vector2 CalculateRotatedPoint(Vector2 p, Vector2 c, float rotation)
        {
            // cx, cy - center of square coordinates
            // x, y - coordinates of a corner point of the square
            // theta is the angle of rotation

            // translate point to origin
            float tempX = p.X - c.X;
            float tempY = p.Y - c.Y;

            // now apply rotation
            float sin = (float)Math.Sin(rotation);
            float cos = (float)Math.Cos(rotation);
            float rotatedX = tempX * cos - tempY * sin;
            float rotatedY = tempX * sin + tempY * cos;

            // translate back
            return new Vector2(rotatedX + c.X, rotatedY + c.Y);
        }

        // Calculate the projection of a polygon on an axis
        // and returns it as a [min, max] interval
        public void ProjectPolygon(Vector2 axis, Polygon polygon,
                                   ref float min, ref float max)
        {
            // To project a point on an axis use the dot product
            float dotProduct = Vector2.Dot(axis, polygon.Points[0]);
            min = dotProduct;
            max = dotProduct;
            for (int i = 0; i < polygon.Points.Length; i++)
            {
                dotProduct = Vector2.Dot(polygon.Points[i], axis);
                if (dotProduct < min)
                {
                    min = dotProduct;
                }
                else
                {
                    if (dotProduct > max)
                    {
                        max = dotProduct;
                    }
                }
            }
        }

        // Calculate the distance between [minA, maxA] and [minB, maxB]
        // The distance will be negative if the intervals overlap
        public float IntervalDistance(float minA, float maxA, float minB, float maxB)
        {
            if (minA < minB)
            {
                return minB - maxA;
            }
            else
            {
                return minA - maxB;
            }
        }

        // Check if polygon A is going to collide with polygon B.
        // The last parameter is the *relative* velocity 
        // of the polygons (i.e. velocityA - velocityB)
        public PolygonCollisionResult PolygonCollision(Polygon polygonA,
                                      Polygon polygonB, Vector2 velocity)
        {
            PolygonCollisionResult result = new PolygonCollisionResult();
            result.Intersect = true;
            result.WillIntersect = true;

            int edgeCountA = polygonA.Edges.Length;
            int edgeCountB = polygonB.Edges.Length;
            float minIntervalDistance = float.PositiveInfinity;
            Vector2 translationAxis = new Vector2();
            Vector2 edge;

            // Loop through all the edges of both polygons
            for (int edgeIndex = 0; edgeIndex < edgeCountA + edgeCountB; edgeIndex++)
            {
                if (edgeIndex < edgeCountA)
                {
                    edge = polygonA.Edges[edgeIndex];
                }
                else
                {
                    edge = polygonB.Edges[edgeIndex - edgeCountA];
                }

                // ===== 1. Find if the polygons are currently intersecting =====

                // Find the axis perpendicular to the current edge
                Vector2 axis = new Vector2(-edge.Y, edge.X);
                axis.Normalize();

                // Find the projection of the polygon on the current axis
                float minA = 0; float minB = 0; float maxA = 0; float maxB = 0;
                ProjectPolygon(axis, polygonA, ref minA, ref maxA);
                ProjectPolygon(axis, polygonB, ref minB, ref maxB);

                // Check if the polygon projections are currentlty intersecting
                if (IntervalDistance(minA, maxA, minB, maxB) > 0)
                    result.Intersect = false;

                // ===== 2. Now find if the polygons *will* intersect =====

                // Project the velocity on the current axis
                float velocityProjection = Vector2.Dot(axis, velocity);

                // Get the projection of polygon A during the movement
                if (velocityProjection < 0)
                {
                    minA += velocityProjection;
                }
                else
                {
                    maxA += velocityProjection;
                }

                // Do the same test as above for the new projection
                float intervalDistance = IntervalDistance(minA, maxA, minB, maxB);
                if (intervalDistance > 0) result.WillIntersect = false;

                // If the polygons are not intersecting and won't intersect, exit the loop
                if (!result.Intersect && !result.WillIntersect) break;

                // Check if the current interval distance is the minimum one. If so store
                // the interval distance and the current distance.
                // This will be used to calculate the minimum translation vector
                intervalDistance = Math.Abs(intervalDistance);
                if (intervalDistance < minIntervalDistance)
                {
                    minIntervalDistance = intervalDistance;
                    translationAxis = axis;

                    Vector2 d = polygonA.Center - polygonB.Center;
                    if (Vector2.Dot(d, translationAxis) < 0)
                        translationAxis = -translationAxis;
                }
            }

            // The minimum translation vector
            // can be used to push the polygons appart.
            if (result.WillIntersect)
                result.MinimumTranslationVector =
                       translationAxis * minIntervalDistance;

            return result;
        }
    }
}
