using System;

namespace CommanderTests
{
    internal class ServiceProviderMock : IServiceProvider
    {
        public object GetService(Type serviceType)
        {
            return null;
        }
    }
}