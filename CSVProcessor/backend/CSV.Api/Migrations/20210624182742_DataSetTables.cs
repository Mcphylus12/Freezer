using Microsoft.EntityFrameworkCore.Migrations;

namespace CSV.Api.Migrations
{
    public partial class DataSetTables : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.CreateTable(
                name: "DataSet",
                columns: table => new
                {
                    Id = table.Column<int>(type: "int", nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    Average = table.Column<double>(type: "float", nullable: false),
                    StdDeviation = table.Column<double>(type: "float", nullable: false),
                    Buckets = table.Column<string>(type: "nvarchar(max)", nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_DataSet", x => x.Id);
                });

            migrationBuilder.CreateTable(
                name: "DataItem",
                columns: table => new
                {
                    Id = table.Column<int>(type: "int", nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    DatasetId = table.Column<int>(type: "int", nullable: true),
                    Value = table.Column<double>(type: "float", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_DataItem", x => x.Id);
                    table.ForeignKey(
                        name: "FK_DataItem_DataSet_DatasetId",
                        column: x => x.DatasetId,
                        principalTable: "DataSet",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Restrict);
                });

            migrationBuilder.CreateIndex(
                name: "IX_DataItem_DatasetId",
                table: "DataItem",
                column: "DatasetId");
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "DataItem");

            migrationBuilder.DropTable(
                name: "DataSet");
        }
    }
}
