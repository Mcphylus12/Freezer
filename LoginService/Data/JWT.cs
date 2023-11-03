using System.Linq;
using MediatR;

namespace LoginService.Data
{
    public class JWTRequest : IRequest<JWTResponse>
    {
    }

    public class JWTResponse
    {
        public string JWT { get; set; }
        
        public JWTResponse(string jwt)
        {
            this.JWT = jwt;
        }
    }
}