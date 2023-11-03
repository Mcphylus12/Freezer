using Microsoft.Xna.Framework;

namespace TankGame.Collision
{
    public class Polygon
    {
        internal Vector2[] Points;
        internal Vector2[] Edges;

        public Vector2 Center
        {
            get
            {
                Vector2 center = new Vector2(0, 0);

                foreach (Vector2 point in Points)
                {
                    center += point;
                }

                center /= Points.Length;

                return center;
            }
        }
    }
}