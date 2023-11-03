function mockFetch(method, path, body) {
    let url = new URL('http://dummy' + path);

    return import('../../mock' + url.pathname).then(mod => {
        let thing = mod[method.toLocaleLowerCase()];

        return thing(url.searchParams, body);
    });
}

import axios from 'axios';

function realFetch(method, path, body) {
    return axios({
        method: method.toLocaleLowerCase(),
        url: path,
        data: body
    }).then(response => response.data);
}

var fetch = mockFetch;

export default fetch;