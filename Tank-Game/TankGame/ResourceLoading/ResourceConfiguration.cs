using Microsoft.Xna.Framework.Content;
using Microsoft.Xna.Framework.Graphics;
using System;
using System.Collections.Generic;
using TankGame.Content.REsourceModels;
using TankGame.GameObjects;

namespace TankGame.ResourceLoading
{
    public class ResourceConfiguration
    {
        Dictionary<Type, IResourceModel> resources;
        private readonly ContentManager content;

        public ResourceConfiguration(ContentManager content)
        {
            resources = new Dictionary<Type, IResourceModel>();
            this.content = content;
        }

        public void LoadResources()
        {
            LoadTankResources();

            LoadMapResource();
        }

        private void LoadMapResource()
        {
            Map1ResourceModel map1 = new Map1ResourceModel();
            map1.MapTexture = LoadTexture("Map");
            resources[typeof(BackgroundMap)] = map1;
        }

        private void LoadTankResources()
        {
            TankResourceModel tankResourceModel = new TankResourceModel();
            tankResourceModel.TankTexture = LoadTexture("test");

            resources[typeof(Tank)] = tankResourceModel;
        }

        private Texture2D LoadTexture(string assetName)
        {
            return content.Load<Texture2D>(assetName);
        }

        public void InjectResourceModel<TResourceModel>(IResourceConsumer<TResourceModel> resourceConsumer)
            where TResourceModel : class
        {
            TResourceModel resourceModel = GetResourceModel(resourceConsumer);
            resourceConsumer.ConfigureResourceModel(resourceModel);
        }

        private TResourceModel GetResourceModel<TResourceModel>(IResourceConsumer<TResourceModel> resourceConsumer) 
            where TResourceModel : class
        {

            Type type = resourceConsumer.GetType();
            if (resources.ContainsKey(type))
                return resources[type] as TResourceModel;
            else
                return null;
        }
    }
}
