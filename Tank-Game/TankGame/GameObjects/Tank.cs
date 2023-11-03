using Microsoft.Xna.Framework;
using Microsoft.Xna.Framework.Graphics;
using TankGame.Content.REsourceModels;
using TankGame.Models;

using Microsoft.Xna.Framework.Input;
using TankGame.Collision;

namespace TankGame.GameObjects
{
    public class Tank : GameObject<TankResourceModel>
    {
        private Texture2D texture;
        private float tankMoveSpeed;
        private float tankRotateSpeed;

        KeyboardState keyboardState;

        public Tank(float x, float y)
            : base()
        {
            Position.SetPosition(x, y);
            InitializeTankMoveSpeed();
        }

        public void InitializeTankMoveSpeed()
        {
            tankMoveSpeed = 3.5f;
            tankRotateSpeed = 0.06f;
        }

        public override void ConfigureResourceModel(TankResourceModel resourceModel)
        {
            this.texture = resourceModel.TankTexture;

            Position.SetDimensions(texture.Width, texture.Height);
        }

        public override void Render(GameTime gameTime, SpriteBatch drawer)
        {
            drawer.Draw(texture,
                new Rectangle((int)(Position.X - Position.W/2), (int)(Position.Y - Position.H /2), (int)Position.W, (int)Position.H),
                null,
                Color.White, 
                Position.GetRotation(), 
                new Vector2(Position.W / 2, Position.H / 2), 
                SpriteEffects.None, 
                DepthValueObject.TANKS);
        }

        public override void Update(GameTime gameTime, IEntityCreator creator, IMovementResolver movementResolver)
        {
            keyboardState = Keyboard.GetState();
            UpdateRotationSpeed();
            UpdateSpeed();

            movementResolver.ResolveAttemptedMove(Position);
        }

        private void UpdateSpeed()
        {
            if (keyboardState.IsKeyDown(Keys.Up))
            {
                Position.SetSpeed(+tankMoveSpeed);
            }
            else if (keyboardState.IsKeyDown(Keys.Down))
            {
                Position.SetSpeed(-tankMoveSpeed);
            }
            else
            {
                Position.SetSpeed(0);
            }
        }

        private void UpdateRotationSpeed()
        {
            if (keyboardState.IsKeyDown(Keys.Right))
            {
                Position.SetRotationSpeed(+tankRotateSpeed);
            }
            else if (keyboardState.IsKeyDown(Keys.Left))
            {
                Position.SetRotationSpeed(-tankRotateSpeed);
            }
            else
            {
                Position.SetRotationSpeed(0);
            }
        }
    }
}
