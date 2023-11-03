using System;
using System.Threading;
using System.Threading.Tasks;
using LoginService.Data;
using MediatR;

namespace Handlers
{
    public class HashRequestHandler : IRequestHandler<HashRequest, HashResponse>
    {
        private readonly IMediator _mediator;

        public HashRequestHandler(IMediator mediator)
        {
            this._mediator = mediator;
        }

        public async Task<HashResponse> Handle(HashRequest request, CancellationToken cancellationToken)
        {
            return new HashResponse(request.Input);
        }
    }
}