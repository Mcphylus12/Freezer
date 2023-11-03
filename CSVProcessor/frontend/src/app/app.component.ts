import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.less']
})
export class AppComponent {
  title = 'csv-front-end';

  data:number[] = [];

  constructor(private http: HttpClient) {}

  openFile(event: any) {
    let input = event.target;
    for (var index = 0; index < input.files.length; index++) {
        let reader = new FileReader();
        reader.onload = () => {
            var text = reader.result as string;
            this.data = text.split(',').map(entry => +entry);
        }
        reader.readAsText(input.files[index]);
    };
  }

  save() {
    this.http.post('https://localhost:5001/api/csv', this.data).subscribe(r => console.log(r));
  }
}
