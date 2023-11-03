namespace LoginService.Models
{
    public class User : IEntity<int>
    {
        public int Key { get; set; }

        public string UserName { get; set; }

        public string Password { get; set; }

        public string Salt { get; set; }
    }
}