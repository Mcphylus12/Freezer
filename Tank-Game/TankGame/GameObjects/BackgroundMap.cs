using Microsoft.Xna.Framework;
using Microsoft.Xna.Framework.Graphics;
using System;
using TankGame.Collision;
using TankGame.Content.REsourceModels;
using TankGame.Models;

namespace TankGame.GameObjects
{
    public class BackgroundMap : GameObject<Map1ResourceModel>
    {
        private Texture2D texture;
        private Rectangle destinationRectangle;
        private Vector2 origin;

        public BackgroundMap(Rectangle mapBounds, float rot = 0)
            : base()
        {
            Position.X = mapBounds.X;
            Position.Y = mapBounds.Y;
            Position.R = rot;
            Position.SetSpeed(0);
        }

        public override void ConfigureResourceModel(Map1ResourceModel resourceModel)
        {
            this.texture = resourceModel.MapTexture;
            Position.W = texture.Width;
            Position.H = texture.Height;
            this.destinationRectangle = new Rectangle((int)(Position.X - Position.W / 2), (int)(Position.Y - Position.H / 2), (int)Position.W, (int)Position.H);
            this.origin = new Vector2(base.Position.W / 2, base.Position.H / 2);
        }

        public override void Render(GameTime gameTime, SpriteBatch drawer)
        {
            drawer.Draw(texture,
                this.destinationRectangle,
                null,
                Color.White,
                base.Position.GetRotation(),
                this.origin,
                SpriteEffects.None,
                DepthValueObject.BACKGROUND);
        }

        public override void Update(GameTime gameTime, IEntityCreator creator, IMovementResolver movementResolver)
        {
        }
    }
}
