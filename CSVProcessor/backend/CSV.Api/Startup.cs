using MediatR;
using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Hosting;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Hosting;
using Microsoft.OpenApi.Models;
using CSV.Api.Command;
using CSV.Api.DB;
using Microsoft.EntityFrameworkCore;

namespace CSV.Api
{
    public class Startup
    {
        private const string CorsOriginPolicy = "AllowSpecificOrigin";

        public Startup(IConfiguration configuration)
        {
            Configuration = configuration;
        }

        public IConfiguration Configuration { get; }

        // This method gets called by the runtime. Use this method to add services to the container.
        public void ConfigureServices(IServiceCollection services)
        {
            services.AddMediatR(typeof(ProcessCSVHandler));
            services.AddControllers();
            services.AddCors(options =>
            {
                options.AddPolicy(CorsOriginPolicy,
                    builder => builder
                            .AllowAnyHeader()
                            .AllowAnyMethod()
                            .AllowAnyOrigin());
            });
            services.AddSwaggerGen(c =>
            {
                c.SwaggerDoc("v1", new OpenApiInfo { Title = "CSV.Api", Version = "v1" });
            });

            services.AddScoped(typeof(IRepository<>), typeof(Repository<>));

            services.AddDbContext<CsvDbContext>(options =>
                options.UseSqlServer("Server=localhost,1433;Database=csvData;User Id=sa;Password=yourStrong(!)Password"));
        }

        // This method gets called by the runtime. Use this method to configure the HTTP request pipeline.
        public void Configure(IApplicationBuilder app, IWebHostEnvironment env, CsvDbContext dbContext)
        {
            dbContext.Database.Migrate();

            if (env.IsDevelopment())
            {
                app.UseDeveloperExceptionPage();
                app.UseSwagger();
                app.UseSwaggerUI(c => c.SwaggerEndpoint("/swagger/v1/swagger.json", "CSV.Api v1"));
            }

            app.UseHttpsRedirection();

            app.UseRouting();

            app.UseCors(CorsOriginPolicy);

            app.UseAuthorization();

            app.UseEndpoints(endpoints =>
            {
                endpoints.MapControllers();
            });
        }
    }
}
