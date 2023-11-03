using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace CSV.Api.DB
{
    public class DataItem
    {
        public int Id { get; set; }
        public DataSet Dataset { get; set; }
        public double Value { get; set; }
    }
}
