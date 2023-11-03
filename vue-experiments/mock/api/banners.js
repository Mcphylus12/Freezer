var get = (query, body) => {
    result = {};
    body.bannerIds.forEach(Id => {
        result[Id] = {};
        result[Id].Id = Id;
        result[Id].message = Id;
    });
    
    return {
        banners: result
    }
}

var post = (query, body) => {
    return {

    }
}

export {
    get, post
}