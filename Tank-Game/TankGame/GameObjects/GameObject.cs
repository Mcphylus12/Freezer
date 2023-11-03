using TankGame.Entities;
using TankGame.Model;
using TankGame.ResourceLoading;

namespace TankGame.GameObjects
{
    public abstract class GameObject<TResourceModel> : Entity, IResourceConsumer<TResourceModel>
    {
        private Position position;

        public override Position Position
        {
            get { return position; }
        }

        protected GameObject()
        {
            position = new Position();
        }

        public abstract void ConfigureResourceModel(TResourceModel resourceModel);
    }
}
