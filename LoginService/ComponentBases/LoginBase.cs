using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using LoginService.Data;
using MediatR;
using Microsoft.AspNetCore.Components;
using Microsoft.AspNetCore.WebUtilities;
using Microsoft.Extensions.Primitives;

namespace LoginService.ComponentBases
{
    public class LoginBase : ComponentBase
    {
        [Inject]
        protected IMediator _mediator { get; set; }

        [Inject]
        protected NavigationManager _navManager { get; set; }

        protected LoginRequest Request = new LoginRequest();

        protected async Task HandleValidSubmit()
        {
            var loginResponse = await this._mediator.Send(Request);

            Console.WriteLine($"Login Response: {loginResponse.Success.ToString()}");

            var jwtResponse = await this._mediator.Send(new JWTRequest());

            var queries = QueryHelpers.ParseQuery(_navManager.Uri);

            StringValues returnURI;

            if (queries.TryGetValue("return", out returnURI))
            {
                var validity = await this._mediator.Send(new ValidateReturnRequest(returnURI));

                if (validity.Valid)
                {
                    var targetURI = QueryHelpers.AddQueryString(returnURI, new Dictionary<string, string>
                    {
                        { "token", jwtResponse.JWT }
                    });

                    // This might shut thue bed
                    this._navManager.NavigateTo(targetURI);
                }
                else
                {

                }
            }
        }
    }
}