using Microsoft.Xna.Framework;
using Microsoft.Xna.Framework.Graphics;
using Microsoft.Xna.Framework.Input;
using System;
using TankGame.Entities;
using TankGame.GameObjects;
using TankGame.ResourceLoading;

namespace TankGame
{
    /// <summary>
    /// This is the main type for your game.
    /// </summary>
    public class TankGame : Game
    {
        private const string WINDOW_TITLE = "TankGame V0.1";
        private const string CONTENT_ROOT = "Content";
        private GraphicsDeviceManager graphics;
        private SpriteBatch spriteBatch;

        public SpriteBatch Drawer
        {
            get { return spriteBatch; }
        }

        public TankGame()
        {
            graphics = new GraphicsDeviceManager(this);
            Content.RootDirectory = CONTENT_ROOT;
        }

        protected override void Initialize()
        {
            Window.Title = WINDOW_TITLE;
            this.IsMouseVisible = true;
            base.Initialize();
        }

        protected override void LoadContent()
        {
            spriteBatch = new SpriteBatch(GraphicsDevice);
            ResourceConfiguration resourceConfiguration = new ResourceConfiguration(Content);
            resourceConfiguration.LoadResources();

            GameObjectCreator gameObjectCreator = new GameObjectCreator(this, resourceConfiguration);
            gameObjectCreator.CreateEntity(new Tank(500, 280));
            gameObjectCreator.CreateEntity(new BackgroundMap(new Rectangle(50, 400, 200, 200)));
            gameObjectCreator.CreateEntity(new BackgroundMap(new Rectangle(50, 100, 100, 100)));
            gameObjectCreator.CreateEntity(new BackgroundMap(new Rectangle(50, 200, 100, 100)));
            gameObjectCreator.CreateEntity(new BackgroundMap(new Rectangle(50, 300, 100, 100)));

            gameObjectCreator.CreateEntity(new BackgroundMap(new Rectangle(800, 100, 100, 100)));
            gameObjectCreator.CreateEntity(new BackgroundMap(new Rectangle(800, 200, 100, 100)));
            gameObjectCreator.CreateEntity(new BackgroundMap(new Rectangle(800, 300, 100, 100)));
            gameObjectCreator.CreateEntity(new BackgroundMap(new Rectangle(800, 400, 100, 100)));

            gameObjectCreator.CreateEntity(new BackgroundMap(new Rectangle(120, 80, 100, 100), (float)Math.PI / 2));
            gameObjectCreator.CreateEntity(new BackgroundMap(new Rectangle(210, 80, 100, 100), (float)Math.PI / 2));
            gameObjectCreator.CreateEntity(new BackgroundMap(new Rectangle(300, 80, 100, 100), (float)Math.PI / 2));
            gameObjectCreator.CreateEntity(new BackgroundMap(new Rectangle(390, 80, 100, 100), (float)Math.PI / 2));
            gameObjectCreator.CreateEntity(new BackgroundMap(new Rectangle(570, 80, 100, 100), (float)Math.PI / 2));
            gameObjectCreator.CreateEntity(new BackgroundMap(new Rectangle(660, 80, 100, 100), (float)Math.PI / 2));
            gameObjectCreator.CreateEntity(new BackgroundMap(new Rectangle(480, 80, 100, 100), (float)Math.PI / 2));
            gameObjectCreator.CreateEntity(new BackgroundMap(new Rectangle(750, 80, 100, 100), (float)Math.PI / 2));

            gameObjectCreator.CreateEntity(new BackgroundMap(new Rectangle(120, 460, 100, 100), (float)Math.PI / 2));
            gameObjectCreator.CreateEntity(new BackgroundMap(new Rectangle(210, 460, 100, 100), (float)Math.PI / 2));
            gameObjectCreator.CreateEntity(new BackgroundMap(new Rectangle(300, 460, 100, 100), (float)Math.PI / 2));
            gameObjectCreator.CreateEntity(new BackgroundMap(new Rectangle(390, 460, 100, 100), (float)Math.PI / 2));
            gameObjectCreator.CreateEntity(new BackgroundMap(new Rectangle(570, 460, 100, 100), (float)Math.PI / 2));
            gameObjectCreator.CreateEntity(new BackgroundMap(new Rectangle(660, 460, 100, 100), (float)Math.PI / 2));
            gameObjectCreator.CreateEntity(new BackgroundMap(new Rectangle(480, 460, 100, 100), (float)Math.PI / 2));
            gameObjectCreator.CreateEntity(new BackgroundMap(new Rectangle(750, 460, 100, 100), (float)Math.PI / 2));
            gameObjectCreator.CreateEntity(new BackgroundMap(new Rectangle(750, 460, 100, 100), (float)Math.PI / 2));

            gameObjectCreator.CreateEntity(new BackgroundMap(new Rectangle(150, 150, 100, 100), (float)Math.PI / 2));
            gameObjectCreator.CreateEntity(new BackgroundMap(new Rectangle(180, 250, 100, 100), (float)Math.PI / 2));
            gameObjectCreator.CreateEntity(new BackgroundMap(new Rectangle(240, 260, 100, 100), (float)Math.PI / 2));


            
        }

        protected override void UnloadContent()
        {
            // TODO: Unload any non ContentManager content here
        }

        protected override void Update(GameTime gameTime)
        {
            base.Update(gameTime);

            if (GamePad.GetState(PlayerIndex.One).Buttons.Back == ButtonState.Pressed || Keyboard.GetState().IsKeyDown(Keys.Escape))
                Exit();
        }

        protected override void Draw(GameTime gameTime)
        {
            GraphicsDevice.Clear(Color.CornflowerBlue);
            base.Draw(gameTime);
        }
    }
}
