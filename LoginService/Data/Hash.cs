using System.Linq;
using MediatR;

namespace LoginService.Data
{
    public class HashRequest : IRequest<HashResponse>
    {
        public string Input { get; set; }

        public HashRequest(params string[] inputs)
        {
            this.Input = inputs.Aggregate((total, next) => total + next);
        }
    }

    public class HashResponse
    {
        public string Response { get; set; }
        
        public HashResponse(string response)
        {
            this.Response = response;
        }
    }
}