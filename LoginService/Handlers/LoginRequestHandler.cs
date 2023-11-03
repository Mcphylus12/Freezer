using System;
using System.Threading;
using System.Threading.Tasks;
using LoginService.Data;
using LoginService.Models;
using MediatR;

namespace Handlers
{
    public class LoginRequestHandler : IRequestHandler<LoginRequest, LoginResponse>
    {
        private readonly IMediator _mediator;
        private readonly IRepository<User, int> _userStore;

        public LoginRequestHandler(IMediator mediator, IRepository<User, int> userStore)
        {
            this._userStore = userStore;
            this._mediator = mediator;
        }

        public async Task<LoginResponse> Handle(LoginRequest request, CancellationToken cancellationToken)
        {
            var user = await this._userStore.Get(user => user.UserName == request.Username);

            if (user == null)
            {
                return new LoginResponse(false);
            }

            HashResponse hashResult = await GenerateHash(request, user);
            return new LoginResponse(hashResult.Response == user.Password);
        }

        private async Task<HashResponse> GenerateHash(LoginRequest request, User user)
        {
            var hash = new HashRequest(request.Password, user.Salt);
            var hashResult = await this._mediator.Send(hash);
            return hashResult;
        }
    }
}