using Microsoft.EntityFrameworkCore;

namespace CSV.Api.DB
{
    public class CsvDbContext : DbContext
    {
        public CsvDbContext(DbContextOptions<CsvDbContext> options) 
            : base(options)
        {
        }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            base.OnModelCreating(modelBuilder);

            modelBuilder.Entity<DataSet>()
                .HasMany(ds => ds.DataItems)
                .WithOne(di => di.Dataset);
        }
    }
}
