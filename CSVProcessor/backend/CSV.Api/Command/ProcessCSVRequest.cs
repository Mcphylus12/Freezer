using MediatR;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace CSV.Api.Command
{
    public class ProcessCSVRequest : IRequest
    {
        public ProcessCSVRequest(double[] numbers)
        {
            Numbers = numbers;
        }

        public double[] Numbers { get; }
    }
}
