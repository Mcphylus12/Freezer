using System.Linq;
using MediatR;
using Microsoft.Extensions.Primitives;

namespace LoginService.Data
{
    public class ValidateReturnRequest : IRequest<ValidateReturnResponse>
    {
        public string returnURI { get; set; }

        public ValidateReturnRequest(string returnURI)
        {
            this.returnURI = returnURI;
        }
    }

    public class ValidateReturnResponse
    {
        public bool Valid { get; set; }
        
        public ValidateReturnResponse(bool valid)
        {
            this.Valid = valid;
        }
    }
}