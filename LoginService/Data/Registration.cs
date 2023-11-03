using MediatR;

namespace LoginService.Data
{
    public class RegistrationRequest : IRequest<RegistrationResponse>
    {
        public string Username { get; set; } = string.Empty;

        public string Password { get; set; } = string.Empty;
    }

    public class RegistrationResponse
    {
        public string? Reason { get; set; }
        public bool Success { get; set; }

        public RegistrationResponse(bool success, string reason)
            : this(success)
        {
            this.Reason = reason;
        }

        public RegistrationResponse(bool success)
        {
            this.Success = success;
        }
    }
}