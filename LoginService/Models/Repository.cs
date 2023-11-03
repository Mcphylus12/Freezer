using System;
using System.Collections.Generic;
using System.Linq;
using System.Linq.Expressions;
using System.Threading.Tasks;

namespace LoginService.Models
{
    public interface IRepository<TEntity, TKey>
        where TEntity : class, IEntity<TKey>
    {
        Task<TEntity?> Get(Expression<Func<TEntity, bool>> whereExpression);

        Task<TEntity?> Get(TKey key);
        
        Task<TEntity> Create(TEntity newEntity);
    }

    public class Repository<TEntity> : IRepository<TEntity, int>
        where TEntity : class, IEntity<int>
    {
        private int pointer = 0;
        private Dictionary<int, TEntity> _entities;

        public Repository()
        {
            _entities = new Dictionary<int, TEntity>();
        }

        public async Task<TEntity> Create(TEntity newEntity)
        {
            this.pointer++;
            newEntity.Key = this.pointer;
            this._entities.Add(pointer, newEntity);
            return newEntity;
        }

        public async Task<TEntity?> Get(Expression<Func<TEntity, bool>> whereExpression)
        {
            var func = whereExpression.Compile();
            return _entities.Values.Where(func).FirstOrDefault();
        }

        public async Task<TEntity?> Get(int key)
        {
            return _entities[key];
        }
    }
}