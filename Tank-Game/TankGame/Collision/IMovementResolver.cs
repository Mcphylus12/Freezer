using Microsoft.Xna.Framework;
using TankGame.Model;

namespace TankGame.Collision
{
    public interface IMovementResolver
    {
        void ResolveAttemptedMove(Position position);
    }
}