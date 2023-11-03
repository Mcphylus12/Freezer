using System;
using System.Threading;
using System.Threading.Tasks;
using LoginService.Data;
using LoginService.Models;
using MediatR;

namespace Handlers
{
    public class RegistrationRequestHandler : IRequestHandler<RegistrationRequest, RegistrationResponse>
    {
        private readonly IMediator _mediator;
        private readonly IRepository<User, int> _userStore;

        public RegistrationRequestHandler(IMediator mediator, IRepository<User, int> userStore)
        {
            this._userStore = userStore;
            this._mediator = mediator;
        }
        public async Task<RegistrationResponse> Handle(RegistrationRequest request, CancellationToken cancellationToken)
        {
            var user = await this._userStore.Get(user => user.UserName == request.Username);

            if (user != null)
            {
                return new RegistrationResponse(false, "User Already Exists");
            }

            User newEntity = await CreateUser(request);
            var newUser = await this._userStore.Create(newEntity);

            return new RegistrationResponse(true);
        }

        private async Task<User> CreateUser(RegistrationRequest request)
        {
            string salt = GenerateSalt();
            HashRequest hashRequest = new HashRequest(request.Password, salt);
            var response = await this._mediator.Send(hashRequest);

            return new User
            {
                Salt = salt,
                UserName = request.Username,
                Password = response.Response
            };
        }

        private string GenerateSalt()
        {
            return string.Empty;
        }
    }
}