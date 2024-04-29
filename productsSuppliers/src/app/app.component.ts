import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router, RouterOutlet } from '@angular/router';
import { NzIconModule } from 'ng-zorro-antd/icon';
import { NzLayoutModule } from 'ng-zorro-antd/layout';
import { NzMenuModule } from 'ng-zorro-antd/menu';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet, NzIconModule, NzLayoutModule, NzMenuModule],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  constructor(private router: Router){

  }
  isCollapsed = false;

  welcomePage(): void {
    this.router.navigate(['/welcome']);
  }

  productsPage(): void {
    this.router.navigate(['/products']);
  }

  suppliersPage(): void {
    this.router.navigate(['/suppliers']);
  }

  tablePage(): void {
    this.router.navigate(['/table']);
  }

  stockTablePage(): void {
    this.router.navigate(['/stockTable']);
  }
}
