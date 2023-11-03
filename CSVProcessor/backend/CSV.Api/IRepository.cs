using Ardalis.Specification;

namespace CSV.Api
{
    public interface IRepository<T> : IRepositoryBase<T> where T : class, IAggregateRoot
    {
    }
}
