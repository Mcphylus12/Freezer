using System;
using Microsoft.Xna.Framework;

namespace TankGame.Model
{
    public class Position
    {
        private Vector2 position;
        private Vector2 rotationDirection;
        private Vector2 dimensions;
        private float rotationAngle;
        float speed;
        float rotationSpeed;

        public Position(float x = 0.0f, float y = 0.0f, float w = 0.0f, float h = 0.0f, float speed = 5.0f, float r = (float)Math.PI)
        {
            position = new Vector2(x, y);
            dimensions = new Vector2(w, h);
            rotationAngle = (float)r;
            this.speed = speed;
            this.rotationSpeed = 0;
            UpdateRotation();
        }

        public float X
        {
            get { return position.X; }
            set { position.X = value; }
        }

        public float Y
        {
            get { return position.Y; }
            set { position.Y = value; }
        }

        public float W
        {
            get { return dimensions.X; }
            set { dimensions.X = value; }
        }

        public float H
        {
            get { return dimensions.Y; }
            set { dimensions.Y = value; }
        }

        public float R
        {
            get { return rotationAngle; }
            set
            {
                rotationAngle = value;
                UpdateDirectionVector();
            }
        }

        public void SetPosition(float x, float y)
        {
            position.X = x;
            position.Y = y;
        }

        internal void SetSpeed(float v)
        {
            speed = v;
        }

        internal void SetRotationSpeed(float v)
        {
            rotationSpeed = v;
        }

        public Vector2 GetPosition()
        {
            return position;
        }

        public void UpdatePosition()
        {
            position += rotationDirection * this.speed;
        }

        public void UpdatePosition(Vector2 offset)
        {
            position += (rotationDirection * this.speed) + offset;
        }

        internal void SetDimensions(int width, int height)
        {
            dimensions.X = width;
            dimensions.Y = height;
        }

        public Vector2 GetDimensions()
        {
            return dimensions;
        }

        public void UpdateRotation()
        {
            rotationAngle += this.rotationSpeed;

            UpdateDirectionVector();
        }

        public float GetRotation()
        {
            return rotationAngle;
        }

        public Vector2 GetDirection()
        {
            return rotationDirection * speed;
        }

        private void UpdateDirectionVector()
        {
            float newX = (float)Math.Sin(rotationAngle);
            float newY = -(float)Math.Cos(rotationAngle);

            rotationDirection.X = newX;
            rotationDirection.Y = newY;

            rotationDirection.Normalize();
        }
    }
}
