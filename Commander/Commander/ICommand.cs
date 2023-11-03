namespace Command
{
    public interface ICommand<TRequest, TResult> 
        where TRequest : IRequest<TResult>
    {
        TResult Execute(TRequest request);
    }
}