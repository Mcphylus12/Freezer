using System;
using System.Collections.Generic;
using LoginService.Data;
using Microsoft.AspNetCore.Components;

namespace LoginService.ComponentBases
{
    public class ManagerBase : ComponentBase
    {
        protected List<string> Returns = new List<string>();
        protected string NewReturn = string.Empty;
        protected string Secret = string.Empty;

        protected void SaveSecret()
        {

        }

        protected void AddReturn()
        {
            Returns.Add(new String(NewReturn));
            NewReturn = string.Empty;
            Console.WriteLine(Returns.Count);
            base.StateHasChanged();
        }

        protected void RemoveReturn(string returnUrl)
        {
            Returns.Remove(returnUrl);
        }
    }
}