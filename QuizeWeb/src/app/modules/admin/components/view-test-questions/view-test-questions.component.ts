import { Component } from '@angular/core';
import { NzCardModule } from 'ng-zorro-antd/card';
import { NzFormModule } from 'ng-zorro-antd/form';

@Component({
  selector: 'app-view-test-questions',
  standalone: true,
  imports: [NzCardModule,NzFormModule],
  templateUrl: './view-test-questions.component.html',
  styleUrl: './view-test-questions.component.scss'
})
export class ViewTestQuestionsComponent {

}
