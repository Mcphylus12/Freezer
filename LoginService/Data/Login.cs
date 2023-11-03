using MediatR;

namespace LoginService.Data
{
    public class LoginRequest : IRequest<LoginResponse>
    {
        public string Username { get; set; } = string.Empty;

        public string Password { get; set; } = string.Empty;
    }

    public class LoginResponse
    {
        internal bool Success;

        public LoginResponse(bool success) => Success = success;
    }
}