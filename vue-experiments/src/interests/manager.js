export default {
    RegisterInterest: (modelType, modelKey) =>
    {
        manager = this._managers[modelType];
        observable = manager.GenerateObservable(modelKey);
        return observable;
    },
    RegisterManager: (modelType, manager) => this._managers[modelType] = manager
}