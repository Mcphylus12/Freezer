using System.Collections.Generic;

namespace CSV.Api.DB
{
    public class DataSet : IAggregateRoot
    {
        public int Id { get; set; }
        public double Average { get; set; }
        public double StdDeviation { get; set; }
        public string Buckets { get; set; }
        public List<DataItem> DataItems { get; set; }
    }
}
