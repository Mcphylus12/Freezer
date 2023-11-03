using CSV.Api.Command;
using MediatR;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Logging;
using System.Threading.Tasks;

namespace CSV.Api.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class CSVController : ControllerBase
    {
        private readonly ILogger<CSVController> logger;
        private readonly IMediator mediator;

        public CSVController(ILogger<CSVController> logger, IMediator mediator)
        {
            this.logger = logger;
            this.mediator = mediator;
        }

        [HttpPost]
        public async Task<IActionResult> AddData(double[] numbers)
        {
            this.logger.LogInformation($"Processing {numbers.Length} records");

            await mediator.Send(new ProcessCSVRequest(numbers));

            return Ok();
        }
    }
}
