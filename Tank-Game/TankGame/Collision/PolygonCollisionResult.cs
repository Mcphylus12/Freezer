using Microsoft.Xna.Framework;

// Structure that stores the results of the PolygonCollision function
public struct PolygonCollisionResult
{
    // Are the polygons going to intersect forward in time?
    public bool WillIntersect;
    // Are the polygons currently intersecting?
    public bool Intersect;
    // The translation to apply to the first polygon to push the polygons apart.
    public Vector2 MinimumTranslationVector;
}