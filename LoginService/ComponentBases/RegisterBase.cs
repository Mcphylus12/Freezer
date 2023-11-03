using System;
using System.Threading.Tasks;
using LoginService.Data;
using MediatR;
using Microsoft.AspNetCore.Components;

namespace LoginService.ComponentBases
{
    public class RegisterBase : ComponentBase
    {
        [Inject]
        protected IMediator _mediator { get; set; }

        protected RegistrationRequest request = new RegistrationRequest();

        protected async Task HandleValidSubmit()
        {
            var regResponse = await this._mediator.Send(request);

             Console.WriteLine($"Reg Response: {regResponse.Success.ToString()}");
        }
    }
}