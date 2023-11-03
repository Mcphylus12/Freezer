using CSV.Api.DB;
using MediatR;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading;
using System.Threading.Tasks;

namespace CSV.Api.Command
{
    public class ProcessCSVHandler : IRequestHandler<ProcessCSVRequest>
    {
        private readonly IRepository<DataSet> repository;

        public ProcessCSVHandler(IRepository<DataSet> respository)
        {
            this.repository = respository;
        }

        public async Task<Unit> Handle(ProcessCSVRequest request, CancellationToken cancellationToken)
        {
            var data = request.Numbers;

            var mean = CalculateMean(data);

            CalculateStats(data, mean, out var max, out var stdDeviation);

            int[] buckets = CreateFrequencyBuckets(data, max);

            await repository.AddAsync(new DataSet
            {
                Average = mean,
                Buckets = string.Join(',', buckets),
                StdDeviation = stdDeviation,
                DataItems = data.Select(i => new DataItem { Value = i }).ToList()
            });

            return Unit.Value;
        }

        private static void CalculateStats(double[] data, double mean, out double max, out double stdDeviation)
        {
            double deviationSum = 0;
            max = double.MinValue;
            foreach (var item in data)
            {
                max = item > max ? item : max;
                deviationSum += Math.Pow(item - mean, 2);
            }

            stdDeviation = Math.Sqrt(deviationSum / data.Length);
        }

        private static int[] CreateFrequencyBuckets(double[] data, double max)
        {
            int binCount = (int)Math.Ceiling(max / 10);
            var buckets = new int[binCount];
            Array.Fill(buckets, 0);

            foreach (var item in data)
            {
                buckets[(int)Math.Floor(item / 10)]++;
            }

            return buckets;
        }

        private double CalculateMean(double[] data)
        {
            double sum = 0;

            foreach (var number in data)
            {
                sum += number;
            }

            return sum / data.Length;
        }
    }
}
