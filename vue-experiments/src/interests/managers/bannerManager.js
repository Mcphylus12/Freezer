import fetch from '../../data/fetcher';
import Observable from "../observable";

export default class BannerManager {
    constructor()
    {
        this._interestCount = {};
        this._observable = new Observable();
    }

    GenerateObservable(bannerKey) {
        let result = new Observable(this._observable);
        result.Pipe([
            banners => {
                for (const banner of banners) {
                    if (banner.Id == bannerKey)
                    {
                        return banner;
                    }
                }
            }])
        return result;
    }

    Start() {
        this.Stop();
        this.interval = setInterval(() => {
            fetch('post', '/api/banners', {bannerIds: this._interestedIds}).then(this._observable.Emit);
        });

        fetch('post', '/api/banners', {bannerIds: this._interestedIds}).then(this._observable.Emit);
    }

    Stop () {
        clearInterval(this.interval);
    }
}