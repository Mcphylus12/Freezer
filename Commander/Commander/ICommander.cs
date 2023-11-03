namespace Command
{
    public interface ICommander
    {
        TResult Execute<TResult>(IRequest<TResult> request);
    }
}