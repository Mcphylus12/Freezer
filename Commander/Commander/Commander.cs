using System;
using System.Collections.Generic;
using Microsoft.Extensions.DependencyInjection;

namespace Command
{
    public class Commander : ICommander
    {
        private readonly IServiceProvider _serviceProvider;
        private Dictionary<Type, object> _cache;

        public Commander(IServiceProvider serviceProvider)
        {
            this._serviceProvider = serviceProvider;
            this._cache = new Dictionary<Type, object>();
        }

        public TResult Execute<TResult>(IRequest<TResult> request)
        {
            var wrapper = GetWrapper<TResult>(typeof(TResult), request.GetType());

            return wrapper.Execute(request);
        }

        private CommandWrapperAbstraction<TResult> GetWrapper<TResult>(Type resultType, Type requestType)
        {
            object wrapper;
            if (!_cache.TryGetValue(requestType, out wrapper))
            {
                wrapper = Activator.CreateInstance(typeof(CommandWrapperImplementation<,>).MakeGenericType(requestType, resultType), _serviceProvider);
                _cache.Add(requestType, wrapper);
            }

            return (CommandWrapperAbstraction<TResult>)wrapper;
        }

        private class CommandWrapperImplementation<TRequest, TResult> : CommandWrapperAbstraction<TResult>
            where TRequest : IRequest<TResult>
        {
            private readonly IServiceProvider _serviceProvider;

            public CommandWrapperImplementation(IServiceProvider serviceProvider)
            {
                this._serviceProvider = serviceProvider;
            }

            internal override TResult Execute(IRequest<TResult> request)
            {
                var command = _serviceProvider.GetRequiredService<ICommand<TRequest, TResult>>();

                return command.Execute((TRequest)request);
            }
        }

        private abstract class CommandWrapperAbstraction<TResult>
        {
            internal abstract TResult Execute(IRequest<TResult> request);
        }
    }

}
