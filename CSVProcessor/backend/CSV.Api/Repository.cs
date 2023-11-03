using Ardalis.Specification.EntityFrameworkCore;
using CSV.Api.DB;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace CSV.Api
{
    public class Repository<T> : RepositoryBase<T>, IRepository<T>
         where T : class, IAggregateRoot
    {
        public Repository(CsvDbContext context)
            : base (context)
        {

        }
    }
}
