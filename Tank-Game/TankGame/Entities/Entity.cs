using Microsoft.Xna.Framework;
using Microsoft.Xna.Framework.Graphics;
using TankGame.Collision;
using TankGame.GameObjects;
using TankGame.Model;

namespace TankGame.Entities
{
    public abstract class Entity : ICollideable
    {
        public abstract Position Position { get; }

        public abstract void Render(GameTime gameTime, SpriteBatch drawer);

        public abstract void Update(GameTime gameTime, IEntityCreator creator, IMovementResolver movementResolver);
    }
}
