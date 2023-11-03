import Vue from 'vue';
var Layouts = {};

function Bootstrap()
{
    Vue.component('layout', {
        props: ["layout"],
        render: function(createElement) {
            let layoutModel = Layouts[this.layout];
            return ProcessNode(layoutModel, createElement);
        }
    })
}

function ProcessNode(model, create)
{
    if (model.component != null)
    {
        return create(model.component, ProcessAttributes(model));
    }

    if (model.children != null)
    {
        let nodes = [];
        for (const child of model.children) {
            nodes.push(ProcessNode(child, create));
        }

        return create('div', ProcessAttributes(model), nodes);
    }
}

function ProcessAttributes(model)
{
    let result = {};
    result.style = model.style;
    result.attrs = model.attrs;
    result.props = model.props;

    if (model.inline)
    {
        result.style = model.style || {};
        result.style.display = "inline-block";
    }

    if (model.classes)
    {
        result.class = {};
        for (const clazz of model.classes) {
            result.class[clazz] = true;
        }
    }

    return result;
}

function RegisterLayout(name, layoutModel)
{
    Layouts[name] = layoutModel
}

export {
    Bootstrap,
    RegisterLayout
}