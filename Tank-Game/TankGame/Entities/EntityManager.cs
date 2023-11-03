using Microsoft.Xna.Framework;
using Microsoft.Xna.Framework.Graphics;
using System.Collections.ObjectModel;
using TankGame.Collision;
using TankGame.GameObjects;

namespace TankGame.Entities
{
    public class EntityManager : DrawableGameComponent
    {
        private SpriteBatch drawer;
        private Collection<Entity> entities;
        private readonly IEntityCreator creator;
        private readonly CollisionManager collisionManager;

        public EntityManager(TankGame game, IEntityCreator creator, CollisionManager collisionManager) : base(game)
        {
            this.drawer = game.Drawer;
            entities = new Collection<Entity>();
            this.creator = creator;
            this.collisionManager = collisionManager;
        }

        public void CreateEntity(Entity entity)
        {
            entities.Add(entity);
            collisionManager.Add(entity);
        }

        public void RemoveEntity(Entity entity)
        {
            entities.Remove(entity);
            collisionManager.Remove(entity);
        }

        public override void Draw(GameTime gameTime)
        {
            base.Draw(gameTime);

            drawer.Begin(SpriteSortMode.FrontToBack);

            foreach (Entity entity in entities)
            {
                entity.Render(gameTime, drawer);
            }

            drawer.End();
        }

        public override void Update(GameTime gameTime)
        {
            base.Update(gameTime);

            foreach (Entity entity in entities)
            {
                entity.Update(gameTime, creator, collisionManager);
            }
        }
    }
}
