var get = (query, body) => {
    return {
        data: query.get("message")
    }
}

var post = (query, body) => {
    return {

    }
}

export {
    get, post
}