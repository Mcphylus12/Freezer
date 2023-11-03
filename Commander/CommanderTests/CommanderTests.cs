using Command;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace CommanderTests
{
    [TestClass]
    public class CommanderTests
    {
        [TestMethod]
        public void CommanderInstantiates()
        {
            Commander commander = new Commander(new ServiceProviderMock());
        }
    }
}
