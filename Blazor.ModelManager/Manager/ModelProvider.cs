﻿using System;

namespace Manager
{
    public class ModelProvider : IModelProvider
    {
        private readonly ModelRequestManagerStore _modelRequestManagerStore;
        private readonly IModelStoreCollection storeCollection;

        public ModelProvider(ModelRequestManagerStore managerStore, IModelStoreCollection storeCollection)
        {
            this._modelRequestManagerStore = managerStore;
            this.storeCollection = storeCollection;
        }

        public IModelHandle<T> RequestHandle<T>()
            where T : class
        {
            IModelRequestManager manager = _modelRequestManagerStore.GetManager<T>();
            IModelStore modelStore = storeCollection.GetStore<T>();
            ModelHandle<T> handle = new ModelHandle<T>(manager, modelStore);

            return handle;
        }
    }
}
