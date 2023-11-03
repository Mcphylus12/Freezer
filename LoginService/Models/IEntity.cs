namespace LoginService.Models
{
    public interface IEntity<TKey>
    {
        TKey Key { get; set; }
    }
}