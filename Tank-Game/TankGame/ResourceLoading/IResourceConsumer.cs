namespace TankGame.ResourceLoading
{
    public interface IResourceConsumer<TResourceModel>
    {
        void ConfigureResourceModel(TResourceModel resourceModel);
    }
}