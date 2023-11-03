export default class Observable {
    constructor(observable) {
        this._callbacks = new Set();
        this._pipes = [];
        
        if (observable !== undefined)
        {
            this._parent = observable;
            source.Subscribe(Emit);
        }
    }

    Subscribe(callback) {
        this._callbacks.add(callback);
    }

    UnSubscribe(callback) {
        this._callbacks.delete(callback);
    }

    Pipe(pipes) {
        this._pipes = pipes;
    }

    Emit(data) {
        result = data;
        this._pipes.forEach(pipe => {
            result = pipe(result);
        });

        this._callbacks.forEach(callback => {
            callback(result);
        })
    }

    Dispose() {
        if (this._parent !== undefined)
        {
            this._parent.UnSubscribe(Emit);
            this._parent = null;
        }
    }
}