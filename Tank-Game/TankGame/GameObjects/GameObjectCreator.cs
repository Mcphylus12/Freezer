using TankGame.Collision;
using TankGame.Entities;
using TankGame.ResourceLoading;

namespace TankGame.GameObjects
{
    class GameObjectCreator : IEntityCreator
    {
        private readonly EntityManager entityManager;
        private readonly ResourceConfiguration resourceConfiguration;

        public GameObjectCreator(TankGame game, ResourceConfiguration resourceConfiguration)
        {
            CollisionManager collisionManager = new CollisionManager();
            this.entityManager = new EntityManager(game, this, collisionManager);
            game.Components.Add(entityManager);
            this.resourceConfiguration = resourceConfiguration;
        }

        public void CreateEntity<TResourceModel>(GameObject<TResourceModel> entity)
            where TResourceModel : class
        {
            resourceConfiguration.InjectResourceModel(entity);
            entityManager.CreateEntity(entity);
        }
    }
}
