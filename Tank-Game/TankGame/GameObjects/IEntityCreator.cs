using TankGame.GameObjects;

namespace TankGame.GameObjects
{
    public interface IEntityCreator
    {
        void CreateEntity<TResourceModel>(GameObject<TResourceModel> entity)
            where TResourceModel : class;
    }
}